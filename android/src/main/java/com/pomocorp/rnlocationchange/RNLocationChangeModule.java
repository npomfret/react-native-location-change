package com.pomocorp.rnlocationchange;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNLocationChangeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNLocationChangeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNLocationChange";
  }

  @ReactMethod
  public void start() {
    //not implemented yet
  }

  @ReactMethod
  public void stop() {
    //not implemented yet
  }
}