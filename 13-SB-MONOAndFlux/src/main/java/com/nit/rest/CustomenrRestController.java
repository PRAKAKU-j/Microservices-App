package com.nit.rest;

import java.awt.PageAttributes.MediaType;
import java.time.Duration;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.CustomerEvent;
import com.sun.el.stream.Stream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class CustomenrRestController {

	@GetMapping(value = "/getEvent",produces = "application/json")
	public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent(){
			CustomerEvent event=new CustomerEvent("Krishan",new Date());
			Mono<CustomerEvent> customentMono = Mono.just(event);
			ResponseEntity<Mono<CustomerEvent>> responseEntity=new ResponseEntity<Mono<CustomerEvent>>(customentMono,HttpStatus.OK);
			return responseEntity;
	}


	@GetMapping(value = "/getEvents",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents(){
			CustomerEvent event=new CustomerEvent("Krishan",new Date());
			Stream<CustomerEvent> customerEvent=Stream.generate(()->event);
			Flux<CustomerEvent> customentFlux =Flux.fromStream(customerEvent);
			
			Flux<Long> interval=Flux.interval(Duration.ofSeconds(5));
			
			Flux<Tuple2<Long, CustomerEvent>> zip=Flux.zip(interval, customentFlux);
			Flux<CustomerEvent> fluxMap=zip.map(Tuple2::getT2);
			
			ResponseEntity<Flux<CustomerEvent>> responseEntity=new ResponseEntity<Flux<CustomerEvent>>(customentFlux,HttpStatus.OK);
			return responseEntity;
	}


}
