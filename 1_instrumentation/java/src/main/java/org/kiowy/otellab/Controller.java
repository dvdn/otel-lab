package org.kiowy.otellab;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  private static final Logger LOGGER = LogManager.getLogger(Controller.class);
  private final AttributeKey<String> ATTR_METHOD = AttributeKey.stringKey("method");

  private final Random random = new Random();
  private final Tracer tracer;
  private final LongHistogram doWorkHistogram;

  @GetMapping("/ping")
  public String ping() throws InterruptedException {
    int sleepTime = random.nextInt(200);
    doWork(sleepTime);
    doWorkHistogram.record(sleepTime, Attributes.of(ATTR_METHOD, "ping"));
    return "pong";
  }

  private void doWork(int sleepTime) throws InterruptedException {
    Span span = tracer.spanBuilder("doWork").startSpan();
    try (Scope ignored = span.makeCurrent()) {
      Thread.sleep(sleepTime);
      LOGGER.info("A sample log message!");
    } finally {
      span.end();
    }
  }
}