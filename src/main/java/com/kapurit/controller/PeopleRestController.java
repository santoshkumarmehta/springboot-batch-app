package com.kapurit.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleRestController {

	@Autowired
	private JobLauncher jobLaunhcer;

	@Autowired
	private Job job;

	@GetMapping("/import")
	public void loadDataToDB() throws Exception {
		
		JobParameters jobParams = 
				new JobParametersBuilder()
					.addLong("startAt", System.currentTimeMillis())
					.toJobParameters();

		jobLaunhcer.run(job, jobParams);
	}
}
