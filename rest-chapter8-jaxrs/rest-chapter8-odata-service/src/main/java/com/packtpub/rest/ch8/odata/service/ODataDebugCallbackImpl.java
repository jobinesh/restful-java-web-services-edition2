/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch8.odata.service;

import org.apache.olingo.odata2.api.ODataDebugCallback;

/**
 * Callback for enabling debugging on OData implmn 
 * @author Jobinesh
 */

public class ODataDebugCallbackImpl implements ODataDebugCallback {
  @Override
  public boolean isDebugEnabled() {  
    boolean isDebug = true;
    return isDebug; 
  }
}