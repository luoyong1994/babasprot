package cn.itcast.core.service.product;

import java.util.List;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.query.product.BrandQuery;

public interface SolrSearchService {
	List<Brand> getBrandList();

}
