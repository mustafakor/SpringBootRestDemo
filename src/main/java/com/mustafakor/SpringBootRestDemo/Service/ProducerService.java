package com.mustafakor.SpringBootRestDemo.Service;

import java.util.List;

import com.mustafakor.SpringBootRestDemo.Entity.Producer;

public interface ProducerService {
	public List<Producer> listAllProducers();
	public void saveProducer(Producer producer);
	public Producer getProducer(int id);
	public void removeProducer(int id);
}
