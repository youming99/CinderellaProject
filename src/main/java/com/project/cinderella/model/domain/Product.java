package com.project.cinderella.model.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
   private int product_id;
   private int topcategory_id;
   private SubCategory subCategory;
   private Psize pppsize;
   private int subcategory_id;
   private String product_name;
   private String brand;
   private int price;
   private String detail;
   private int hit;
   private String filename; // currentTimeMils�� �� ����
   

   // �̹��� �ϳ��� �ڵ����� ó���ϴ� ��ü ����
   // ��, �̸��� html�� ������ ������Ʈ �Ķ���͸�� ��ġ���Ѿ� �ڵ����� ���ε� ó��
   private MultipartFile repImg; // ��ǥ�̹���
   private MultipartFile[] addImg; // �߰� �̹����� ���û���. �迭.

   // ������ �� ���
   //private Score score;
   private List<Psize> psizeList;
   private List<Color> colorList;
   private List<Tag> tagList;
   private List<Gender> genderList;
   private List<Image> imageList;
   

   // insert�� �� ���
   private Psize[] psize; // ������
   private Color[] color; // ���󰪵�
   private Tag[] ptag; // �±׵�
   private Gender[] pgender; // ����

}