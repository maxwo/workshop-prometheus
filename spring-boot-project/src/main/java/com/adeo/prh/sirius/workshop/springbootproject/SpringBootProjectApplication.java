package com.adeo.prh.sirius.workshop.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Bean
	@ExportMetricWriter
	protected MetricWriter metricWriter(final MBeanExporter exporter) {
	    return new JmxMetricWriter(exporter);
	}
}
