package cn.itcast.core.service.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.product.Brand;
import cn.itcast.core.dao.product.SolrSearchDao;

@Service
public class SolrSearchServiceImpl implements SolrSearchService{

	@Resource
	private SolrSearchDao solrSearchDao;

	@Transactional(readOnly = true)
	@Override
	public List<Brand> getBrandList() {
		return solrSearchDao.getBrandList();
	}
	

}
