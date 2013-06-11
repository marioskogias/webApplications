#!/bin/bash

javac bvShop/BVCatalog.java
echo "Compiled correctly"

jar cvf exe.jar bvShop/VehicleBean.class bvShop/BVCatalog.class bvShop/MotorBean.class
echo "Made the jar"

cp exe.jar /Users/marioskogias/Desktop/jakarta-tomcat-3.3.2/lib/common
echo "Copied the jar"

java org.apache.soap.server.ServiceManagerClient http://localhost:8080/soap/servlet/rpcrouter deploy BVCatalogDD.xml
echo "deployed"
