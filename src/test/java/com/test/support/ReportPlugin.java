package com.test.support;


import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;

import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

public class 	ReportPlugin implements EventListener {
	
      private final Map<URI, String> testSource = new TreeMap<URI, String>();
      private final Map<String, String> definedSteps = new TreeMap<>();
	private final Map<String, Status> finishedSteps = new TreeMap<String, io.cucumber.plugin.event.Status>();
	private final Map<String, Status> finishedCases = new TreeMap<String, Status>();
    private final Map<String, String> startedCases = new TreeMap<String, String>();
    
	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestSourceRead.class, this::handleTestSourceEvent);
		publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
		publisher.registerHandlerFor(StepDefinedEvent.class, this::handleStepDefinedEvent);
		publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
		publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
		
	}

	private void handleTestSourceEvent(TestSourceRead event) {
		testSource.put(event.getUri(), event.getSource());
	for (Map.Entry<URI, String> entry : testSource.entrySet()) {
				URI location = entry.getKey();
				String pattern = entry.getValue();
				System.out.println(location + " %%%fromTestSourceRead%%% " + pattern);
			}
		
	}
	
	private void handleStepDefinedEvent(StepDefinedEvent event) {
		definedSteps.put(event.getStepDefinition().getLocation(), event.getStepDefinition().getPattern());
	for (Map.Entry<String, String> entry : definedSteps.entrySet()) {
				String location = entry.getKey();
				String pattern = entry.getValue();
				System.out.println(location + " ****fromStepDefined**** " + pattern);
			}
		
	}

	private void handleTestStepFinished(TestStepFinished event) {
		finishedSteps.put(event.getTestStep().getCodeLocation(), event.getResult().getStatus());
		for (Map.Entry<String, Status> entry : finishedSteps.entrySet()) {
				String location = entry.getKey();
				Status pattern = entry.getValue();
				System.out.println(location + " ###fromTestStepFinished### " + pattern);
			}
	}

	private void handleTestCaseFinished(TestCaseFinished event) {
		
		finishedCases.put(event.getTestCase().getUri() + "::::" + event.getTestCase().getLine(),
				event.getResult().getStatus());
		for (Map.Entry<String, Status> entry : finishedCases.entrySet()) {
				String location = entry.getKey();
				Status pattern = entry.getValue();
				System.out.println(location + " @@@@fromTestCaseFinished@@@@ " + pattern);
			}
	}
	
	private void handleTestCaseStarted(TestCaseStarted event) {
		
		startedCases.put(event.getTestCase().getUri() + "::::" + event.getTestCase().getLine(),
				event.getTestCase().getName());
		for (Map.Entry<String, String> entry : startedCases.entrySet()) {
				String location = entry.getKey();
				String pattern = entry.getValue();
				System.out.println(location + " !!!!fromTestCaseStarted!!!! " + pattern);
			}
	}
}
