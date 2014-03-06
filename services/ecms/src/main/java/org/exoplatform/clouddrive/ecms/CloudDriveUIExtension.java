/*
 * Copyright (C) 2003-2014 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.exoplatform.clouddrive.ecms;

import org.exoplatform.container.component.BaseComponentPlugin;
import org.exoplatform.container.xml.InitParams;
import org.exoplatform.container.xml.ValuesParam;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Configuration of Cloud Drive menu in ECMS.
 * 
 * Created by The eXo Platform SAS.
 * 
 * @author <a href="mailto:pnedonosko@exoplatform.com">Peter Nedonosko</a>
 * @version $Id: CloudDriveUIExtension.java 00000 Jan 31, 2014 pnedonosko $
 * 
 */
public class CloudDriveUIExtension extends BaseComponentPlugin {

  protected static final Log  LOG            = ExoLogger.getLogger(CloudDriveUIExtension.class);

  protected final Set<String> defaultActions = new HashSet<String>();

  /**
   * 
   */
  public CloudDriveUIExtension(InitParams config) {
    ValuesParam params = config.getValuesParam("default-actions");
    if (params != null) {
      for (Object ov : params.getValues()) {
        if (ov instanceof String) {
          defaultActions.add((String) ov);
          // TODO cleanup
          // try {
          // Class<?> extClass = Class.forName(className);
          // if (UIComponent.class.isAssignableFrom(extClass)) {
          // defaultActions.add(extClass);
          // } else {
          // LOG.warn("Action class " + className + " not an UIExtension.");
          // }
          // } catch (ClassNotFoundException e) {
          // LOG.warn("Cannot load extension class " + className + " : " + e.getMessage());
          // }
        }
      }
    } else {
      LOG.warn("Value parameters' default-actions not specified. Nothing will be configured in ECMS menu for Cloud Drive.");
    }
  }

  public Collection<String> getDefaultActions() {
    return Collections.unmodifiableSet(defaultActions);
  }
}
