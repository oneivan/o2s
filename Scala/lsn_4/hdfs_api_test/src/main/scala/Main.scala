import org.apache.hadoop.conf._
import org.apache.hadoop.fs._
import java.net.URI
import scala.io.Source

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io._

object Main extends App {
  val conf = new Configuration()
  println( conf )

  val hdfs_fs = FileSystem.get( new URI("hdfs://localhost:9000"), conf ) // cluster-c9qfs1j50vll653s5d4k.dataproc-ui.yandexcloud.net
  val hdfs_f  = new Path("/stage/date=2020-12-01/part-0001.csv.inprogress")

  println( conf )
  // create dir for output:
  val out_pth = new Path( "/tmp/ods")
  if ( ! hdfs_fs.exists( out_pth ) ) {
    hdfs_fs.mkdirs( out_pth )
  }

  val in = hdfs_fs.open( hdfs_f )
  println( in.readLine() )
  in.close()
}


/*

docker cp namenode:/etc/hadoop/capacity-scheduler.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/configuration.xsl ./etc_hadoop
docker cp namenode:/etc/hadoop/container-executor.cfg ./etc_hadoop
docker cp namenode:/etc/hadoop/core-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/hadoop-env.cmd ./etc_hadoop
docker cp namenode:/etc/hadoop/hadoop-env.sh ./etc_hadoop
docker cp namenode:/etc/hadoop/hadoop-user-functions.sh.example ./etc_hadoop
docker cp namenode:/etc/hadoop/hdfs-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/httpfs-env.sh ./etc_hadoop
docker cp namenode:/etc/hadoop/httpfs-log4j.properties ./etc_hadoop
docker cp namenode:/etc/hadoop/httpfs-signature.secret ./etc_hadoop
docker cp namenode:/etc/hadoop/httpfs-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/kms-acls.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/kms-env.sh ./etc_hadoop
docker cp namenode:/etc/hadoop/kms-log4j.properties ./etc_hadoop
docker cp namenode:/etc/hadoop/kms-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/mapred-env.sh ./etc_hadoop
docker cp namenode:/etc/hadoop/mapred-queues.xml.template ./etc_hadoop
docker cp namenode:/etc/hadoop/mapred-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/shellprofile.d ./etc_hadoop
docker cp namenode:/etc/hadoop/ssl-client.xml.example ./etc_hadoop
docker cp namenode:/etc/hadoop/ssl-server.xml.example ./etc_hadoop
docker cp namenode:/etc/hadoop/user_ec_policies.xml.template ./etc_hadoop
docker cp namenode:/etc/hadoop/workers ./etc_hadoop
docker cp namenode:/etc/hadoop/yarn-env.cmd ./etc_hadoop
docker cp namenode:/etc/hadoop/yarn-env.sh ./etc_hadoop
docker cp namenode:/etc/hadoop/yarn-site.xml ./etc_hadoop
docker cp namenode:/etc/hadoop/yarnservice-log4j.properties ./etc_hadoop

cp ./etc_hadoop/ /mnt/c/Users/oneiv/dev/edu/scala/otus/GitHub/edu_scala_otus/lsn_4/hdfs_api_test/

*/