package com.mustafakor.SpringBootRestDemo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustafakor.SpringBootRestDemo.Entity.Producer;
import com.mustafakor.SpringBootRestDemo.Repository.ProducerRepository;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private ProducerRepository producerRepository;
	
	@Override
	public List<Producer> listAllProducers() {
		return producerRepository.findAll();
	}

	@Override
	public void saveProducer(Producer producer) {
		producerRepository.save(producer);
	}

	@Override
	public Producer getProducer(int id) {
		return producerRepository.getOne(id);
	}

	@Override
	public void removeProducer(int id) {
		producerRepository.deleteById(id);
	}

	
	
}
