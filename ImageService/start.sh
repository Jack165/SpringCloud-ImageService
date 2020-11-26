DATE=$(date +%Y%m%d)
DIR=//var/lib/jenkins/workspace/ImageServer/ImageService/target
JARFILE=ImageService-0.0.1-SNAPSHOT.jar
 
if [ ! -d $DIR/backup ];then
   mkdir -p $DIR/backup
fi
cd $DIR

ls
pid=`ps -ef | $JARFILE | grep -v grep | awk '{print $2}'`
if [ -n "$pid" ]
then
   echo "kill -9 的pid:" $pid
   kill -9 $pid
fi
BUILD_ID=dontKillMe  nohup java  -Dhudson.util.ProcessTree.disable=true  -jar  $JARFILE > out.log &
