package org.vaadin.example;

import dev.restate.sdk.JsonSerdes;
import dev.restate.sdk.ObjectContext;
import dev.restate.sdk.annotation.Handler;
import dev.restate.sdk.common.StateKey;
import dev.restate.sdk.springboot.RestateVirtualObject;

@RestateVirtualObject
public class Greeter {

  private final static StateKey<Integer> COUNTER = StateKey.of("counter", JsonSerdes.INT);

  @Handler
  public String greet(ObjectContext ctx) {
    var count = ctx.get(COUNTER).orElse(0);
    count++;
    ctx.set(COUNTER, count);
    return "Hello " + ctx.key() + " for the " + count + "th time!";
  }

}