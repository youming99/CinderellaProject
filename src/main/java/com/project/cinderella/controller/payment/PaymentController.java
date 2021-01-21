package com.project.cinderella.controller.payment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.cinderella.common.MessageData;
import com.project.cinderella.exception.CartException;
import com.project.cinderella.exception.LoginRequiredException;
import com.project.cinderella.model.domain.Cart;
import com.project.cinderella.model.domain.Member;
import com.project.cinderella.model.domain.OrderSummary;
import com.project.cinderella.model.domain.Receiver;
import com.project.cinderella.model.member.service.MemberService;
import com.project.cinderella.model.payment.service.PaymentService;
import com.project.cinderella.model.product.service.TopCategoryService;

@Controller
public class PaymentController {
   private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

   @Autowired
   private PaymentService paymentService;

   @Autowired
   private TopCategoryService topCategoryService;
   
   @Autowired
   private MemberService memberService;

   // ��ٱ��Ͽ� ��ǰ ��� ��û
   @RequestMapping(value = "/shop/cart/regist", method = RequestMethod.POST)
   @ResponseBody
   public MessageData registCart(Cart cart, HttpSession session) {
      if (session.getAttribute("member") == null) {
         throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�.");
      }

      Member member = (Member) session.getAttribute("member");

      logger.debug("product_id " + cart.getProduct_id());
      logger.debug("quantity " + cart.getQuantity());
      cart.setMember_id(member.getMember_id());
      paymentService.insert(cart);

      // MessageConverter �� ���� VO�� JSON���·� ����Ǿ��� �� �ִ�!!
      MessageData messageData = new MessageData();
      messageData.setResultCode(1);
      messageData.setMsg("��ٱ��Ͽ� ��ǰ�� �����ϴ�");
      messageData.setUrl("/cinderella/shop/cart/list");

      return messageData;
   }

   // ��ٱ��� ��� ��û
   @RequestMapping(value = "/shop/cart/list", method = RequestMethod.GET)
   public ModelAndView getCartList(HttpServletRequest request, HttpSession session) {
      if (session.getAttribute("member") == null) {
         throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�.");
      }
      Member member = (Member) session.getAttribute("member");
      List topList = topCategoryService.selectAll();
      List cartList = paymentService.selectCartList(member.getMember_id());

      ModelAndView mav = new ModelAndView();
      mav.addObject("topList", topList);
      mav.addObject("cartList", cartList);
      mav.setViewName("shop/cart/cart_list");
      return mav;
   }

   // ��ٱ��� ���� ��û
   @RequestMapping(value = "/shop/cart/del", method = RequestMethod.GET)
   public String delCart(HttpSession session) {
      // ��ٱ��ϸ� �����ϱ� ���ؼ���, �α����� ȸ���� ����..
      if (session.getAttribute("member") == null) {
         throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�");
      }
      paymentService.delete((Member) session.getAttribute("member"));

      return "redirect:/shop/cart/list";
   }

   // ��ٱ��� ��� ����
   @RequestMapping(value = "/shop/cart/edit", method = RequestMethod.POST)
   public ModelAndView editCart(@RequestParam("cart_id") int[] cartArray, @RequestParam("quantity") int[] qArray) {
      // �Ѱܹ��� �Ķ���� ����ϱ�!! cart_id, quantity
      logger.debug("cartArray length " + cartArray.length);

      List cartList = new ArrayList();
      for (int i = 0; i < cartArray.length; i++) {
         Cart cart = new Cart();
         cart.setCart_id(cartArray[i]);
         cart.setQuantity(qArray[i]);
         cartList.add(cart);
      }
      paymentService.update(cartList);

      // �����Ǿ��ٴ� �޽����� ����ʹٸ�.. message.jsp�� ��������
      MessageData messageData = new MessageData();
      messageData.setResultCode(1);
      messageData.setMsg("��ٱ��ϰ� �����Ǿ����ϴ�");
      messageData.setUrl("/cinderella/shop/cart/list");
      ModelAndView mav = new ModelAndView();
      mav.addObject("messageData", messageData);
      mav.setViewName("shop/error/message");

      return mav;
   }

   // üũ�ƿ� ������ ��û
   @GetMapping("/shop/payment/form")
   public ModelAndView payForm(HttpServletRequest request, HttpSession session) {
      ModelAndView mav = new ModelAndView();
      List topList = topCategoryService.selectAll();
      mav.addObject("topList", topList); // ModelAndView������ Model�� ���..

      // �������� ��������
      List paymethodList = paymentService.selectPaymethodList();
      mav.addObject("paymethodList", paymethodList);

      // ��ٱ��� ������ ��������
      Member member = (Member) session.getAttribute("member");
      List cartList = paymentService.selectCartList(member.getMember_id());
      mav.addObject("cartList", cartList);
      mav.setViewName("shop/payment/checkout");
      return mav;
   }

   // ������û ó��
   @RequestMapping(value = "/shop/payment/regist", method = RequestMethod.POST, produces = "text/html;charset=utf8")
   @ResponseBody
   public String pay(HttpSession session, OrderSummary orderSummary, Receiver receiver) {
      
      logger.debug("d"+orderSummary.getOrder_summary_id());
      logger.debug("d"+orderSummary.getTotal_pay());
      logger.debug("d"+orderSummary.getTotal_price());
      logger.debug("d"+orderSummary.getPaymethod_id());
       
      Member member = (Member) session.getAttribute("member");
      orderSummary.setMember_id(member.getMember_id()); // ȸ�� pk

      paymentService.registOrder(orderSummary, receiver);
      memberService.updateBuyCount(member, member.getMember_id());
      
      
      paymentService.delete((Member) session.getAttribute("member"));
      StringBuilder sb = new StringBuilder();
      sb.append("{");
      sb.append("\"result\":1,");
      sb.append("\"msg\":\"���� ����\"");
      sb.append("}");
      return sb.toString();
   }
   
   //�ֹ���� Ȯ�� - ������
   @RequestMapping(value = "/admin/product/order_list", method = RequestMethod.GET)
   public ModelAndView getOrderList() {
      ModelAndView mav = new ModelAndView("admin/product/order_list");
      List orderList = paymentService.selectOrderList();
      List memberList = memberService.selectAll();
      List orderstateList = paymentService.selectOrderStateList();
      mav.addObject("orderList", orderList);
      mav.addObject("memberList", memberList);
      mav.addObject("orderstateList", orderstateList);
      return mav;
   }
   
   
   

   // ��ٱ��Ͽ� ���õ� ����ó�� �ڵ鷯
   @ExceptionHandler(CartException.class)
   @ResponseBody
   public MessageData handleException(CartException e) {
      logger.debug("�ڵ鷯 ������ " + e.getMessage());
      MessageData messageData = new MessageData();
      messageData.setResultCode(0);
      messageData.setMsg(e.getMessage());
      messageData.setUrl("/cinderella/shop/member/signin");

      return messageData;
   }
   
   
   
}