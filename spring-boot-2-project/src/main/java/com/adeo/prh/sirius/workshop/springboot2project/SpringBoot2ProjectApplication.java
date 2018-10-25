package com.adeo.prh.sirius.workshop.springboot2project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

@SpringBootApplication
public class SpringBoot2ProjectApplication {
	
	public static final MeterRegistry METER_REGISRTY = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2ProjectApplication.class, args);
	}
}
