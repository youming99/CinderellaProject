package com.project.cinderella.controller.preview;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.project.cinderella.common.FileManager;
import com.project.cinderella.model.domain.Comments;
import com.project.cinderella.model.domain.Member;
import com.project.cinderella.model.domain.PhotoReview;
import com.project.cinderella.model.domain.Product;
import com.project.cinderella.model.member.service.MemberService;
import com.project.cinderella.model.preview.service.PhotoReviewService;
import com.project.cinderella.model.product.service.CommentsService;
import com.project.cinderella.model.product.service.ProductService;
import com.project.cinderella.model.product.service.TopCategoryService;

@Controller
public class PhotoReviewController implements ServletContextAware{
	private static final Logger logger=LoggerFactory.getLogger(PhotoReviewController.class);
	@Autowired
	private FileManager filemanager;
	
	@Autowired
	private PhotoReviewService photoReviewService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentsService commentsService;

	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		//�� Ÿ�̹��� ��ġ������, ���� ������ ��θ� FileManager �� �����س���!!!

		filemanager.setSavepreviewBasicDir(servletContext.getRealPath(filemanager.getSavepreviewBasicDir()));
		logger.debug(filemanager.getSavepreviewBasicDir());
		
	}
	
	
	//�����ڸ�忡�� ȸ�� ���丮���� ����
    @RequestMapping(value = "/admin/member/member_photoreviewlist", method = RequestMethod.GET)
    public ModelAndView getAdminPhotoReviewList() {
      ModelAndView mav = new ModelAndView("admin/member/member_photoreviewlist");
       List photoReviewList = photoReviewService.selectAll();
       mav.addObject("photoReviewList", photoReviewList);
       return mav;
    }
    //�����ڸ�忡�� ���丮������Ϻ���
    @RequestMapping(value = "/admin/member/member_photoreviewdetail", method =  RequestMethod.GET)
    public ModelAndView getAdminPhotoReviewDetail(int photoreview_id) {
    	
    	logger.debug("photorevierw_id=",photoreview_id);
    	PhotoReview photoReview = photoReviewService.select(photoreview_id);
    	ModelAndView mav = new ModelAndView("admin/member/member_photoreviewdetail");
    	mav.addObject("photoReview", photoReview);
    	return mav;
    }
    
    //������ ���丮�� �����Ͽ��� ���� �߼��ϱ�
    @RequestMapping(value = "/admin/member/shot_email", method = RequestMethod.POST)
    public String getAdminShotEmail(@RequestParam("user_id")String user_id) {
    	System.out.println("user_id:"+user_id);
    	memberService.shotmail(user_id);
    	return "redirect:/admin/member/member_photoreviewlist";
    }
	/********************shop************************************************************************/
	
		@RequestMapping(value = "/shop/photoreview/registform", method = RequestMethod.GET)
		public ModelAndView registForm(Member member, HttpServletRequest request) {
			List topList = topCategoryService.selectAll();
			logger.debug("��������ﲲ");
			/*
			 * Member obj = memberService.select(member); // ���� O : ���ǿ� ȸ������ ��Ƶα�
			 * HttpSession session = request.getSession();
			 */
			ModelAndView mav = new ModelAndView();
			//session.setAttribute("member", obj);
			mav.addObject("topList", topList);
			mav.setViewName("shop/photoreview/regist_form");
			return mav;
		}
		//���
		@RequestMapping(value = "/shop/photoreview/regist", method = RequestMethod.POST, produces ="text/html;charset=utf8")
		@ResponseBody
		public String reviewRegist(PhotoReview photoReview) {
			System.out.println("photoReview="+photoReview);
			
			photoReviewService.regist(filemanager, photoReview);
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			sb.append("\"result\":1,");
			sb.append("\"msg\":\"������ ����\"");
			sb.append("}");
			return sb.toString();
		}
		//����
		@RequestMapping(value = "/shop/photoreview/delete" , method = RequestMethod.GET)
		@ResponseBody
		public List delPhotoReview(int photoreView_id) {
			photoReviewService.delete(photoreView_id);
			List photoReviewList = photoReviewService.selectAll();
			return  photoReviewList;
		}
		//mylog���� ����
		@RequestMapping(value = "/shop/photoreview/deleteandshowbyid" , method = RequestMethod.GET)
		@ResponseBody
		public ModelAndView delMyLogPhotoReview(int photoreView_id,String user_id) {
			ModelAndView mav = new ModelAndView();
			List topList = topCategoryService.selectAll();
			
			photoReviewService.delete(photoreView_id);
			
			mav.setViewName("redirect:/shop/member/mylog?user_id="+user_id);
			return mav;
	
		}
		//ī����
		@RequestMapping(value = "/shop/photoreview/list", method = RequestMethod.GET)
		public ModelAndView getPhotoReviewList() {
			List topList = topCategoryService.selectAll();
			List photoReviewList = photoReviewService.selectAll();
			ModelAndView mav = new ModelAndView();
			mav.addObject("topList", topList);
			mav.addObject("photoReviewList", photoReviewList);

			mav.setViewName("shop/photoreview/list");
			return mav;
		}
	
		
}
