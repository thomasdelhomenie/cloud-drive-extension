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
package org.exoplatform.clouddrive;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * An API to synchronize cloud files with its state on provider side.
 * 
 * Created by The eXo Platform SAS.
 * 
 * @author <a href="mailto:pnedonosko@exoplatform.com">Peter Nedonosko</a>
 * @version $Id: CloudFileAPI.java 00000 Mar 21, 2014 pnedonosko $
 * 
 */
public interface CloudFileAPI {

  String getId(Node fileNode) throws RepositoryException;

  String getTitle(Node fileNode) throws RepositoryException;

  String getParentId(Node fileNode) throws RepositoryException;

  Collection<String> findParents(Node fileNode) throws DriveRemovedException, RepositoryException;

  boolean isFolder(Node node) throws RepositoryException;

  boolean isFile(Node node) throws RepositoryException;

  boolean isFileResource(Node node) throws RepositoryException;

  boolean isIgnored(Node node) throws RepositoryException;

  /**
   * Mark given file as ignored by adding ecd:ignored mixin to it.
   * 
   * @param node {@link Node}
   * @throws RepositoryException
   */
  void ignoreFile(Node node) throws RepositoryException;

  String createFile(Node fileNode, Calendar created, Calendar modified, String mimeType, InputStream content) throws CloudDriveException,
                                                                                                             RepositoryException;

  String createFolder(Node folderNode, Calendar created) throws CloudDriveException, RepositoryException;

  void updateFolder(Node folderNode, Calendar modified) throws CloudDriveException, RepositoryException;

  void updateFile(Node fileNode, Calendar modified) throws CloudDriveException, RepositoryException;

  void updateFileContent(Node fileNode, Calendar modified, String mimeType, InputStream content) throws CloudDriveException,
                                                                                                RepositoryException;

  String copyFile(Node srcFileNode, Node destFileNode) throws CloudDriveException, RepositoryException;

  String copyFolder(Node srcFolderNode, Node destFolderNode) throws CloudDriveException, RepositoryException;

  void removeFile(String id) throws CloudDriveException, RepositoryException;

  void removeFolder(String id) throws CloudDriveException, RepositoryException;

  boolean isTrashSupported();

  boolean trashFile(String id) throws CloudDriveException, RepositoryException;

  boolean trashFolder(String id) throws CloudDriveException, RepositoryException;

  boolean untrashFile(Node fileNode) throws CloudDriveException, RepositoryException;

  boolean untrashFolder(Node fileNode) throws CloudDriveException, RepositoryException;

}