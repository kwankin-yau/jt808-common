/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

import java.io.{Closeable, InputStream, OutputStream}


trait FileRepository {
  def bucket(name: String): FileBucket
}

object FileBucketNames {
  val AlmAtt = "almatt"
  val MultiMedia = "mm"
  val AvUpload = "av-upload"
  val Strm = "strm"
}

trait FileBucket {
  def bucketName: String
  def exist(fileName: String): Boolean
  def create(fileName: String): WritableFileResource
  def openRead(fileName: String): ReadableFileResource
  def delete(fileName: String): Boolean
}

trait FileResource extends Closeable{
  def getBucket: FileBucket
  def getFileName: String
}

trait WritableFileResource extends FileResource {

  /**
   * Get OutputStream object of this resource. Note that the output stream will be created in this resource object creation,
   * and return the reference each time this method called. This output stream will be closed when the close() method
   * of resource called.
   *
   * @return OutputStream object of this resource
   */
  def outputStream(): OutputStream
}

trait ReadableFileResource extends FileResource {

  /**
   * Get InputStream object of this resource. Note that the input stream will created in this resource object creation,
   * and return the reference each time this method called. This input stream will be closed when the close() method
   * of resource called.
   *
   * @return InputStream object of this resource
   */
  def inputStream(): InputStream
}

trait FileResourceResolver {
  def url(bucketName: String, fileWithPath: String): String
  def url(resource: FileResource): String = url(resource.getBucket.bucketName, resource.getFileName)
}
