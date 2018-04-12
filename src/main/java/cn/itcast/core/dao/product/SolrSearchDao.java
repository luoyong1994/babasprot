package cn.itcast.core.dao.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;


public interface SolrSearchDao {
	List<Brand> getBrandList();

}
