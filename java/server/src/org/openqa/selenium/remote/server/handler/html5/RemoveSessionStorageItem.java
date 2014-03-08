/*
Copyright 2010 Selenium committers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.remote.server.handler.html5;

import org.openqa.selenium.remote.server.Session;
import org.openqa.selenium.remote.server.handler.ResponseAwareWebDriverHandler;
import org.openqa.selenium.remote.server.rest.ResultType;

public class RemoveSessionStorageItem extends ResponseAwareWebDriverHandler {
  private volatile String key;

  public RemoveSessionStorageItem(Session session) {
    super(session);
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public ResultType call() throws Exception {
    Object value = Utils.getWebStorage(getUnwrappedDriver())
        .getSessionStorage().removeItem(key);
    response.setValue(value);
    return ResultType.SUCCESS;
  }

  @Override
  public String toString() {
    return String.format("[remove session storage item for key: %s]", key);
  }
}
