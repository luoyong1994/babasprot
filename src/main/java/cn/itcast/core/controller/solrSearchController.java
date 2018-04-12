package cn.itcast.core.controller;

import java.util.List;

import javax.swing.text.Document;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.service.product.SolrSearchService;

@Controller
public class solrSearchController {
	@Autowired
	private SolrSearchService solrSearchService;
	private final static String  baseUrl="http://localhost:8080/solr";
	
	public void getProduct() {
		List<Brand> brands = solrSearchService.getBrandList();
		try {
			if(null!=brands) {
				SolrInputDocument document = new SolrInputDocument();
				for(Brand brand : brands) {
					document.setField("bbs_id", brand.getId());
					document.setField("bbs_name", brand.getName());
					document.setField("bbs_description", brand.getDescription());
					document.setField("bbs_img_url", brand.getImgUrl());
					document.setField("bbs_sort", brand.getSort());
					document.setField("bbs_is_display", brand.getIsDisplay());				
				}			
				SolrServer solrServer = new HttpSolrServer(baseUrl);
				solrServer.add(document);
				solrServer.commit();
			}			
		}catch(Exception e) {
			throw new RuntimeException("solr数据初始失败");
		}
	}
	
}
