package com.waterspringer.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.waterspringer.iot_datarecive.entity.DeviceData;
import com.waterspringer.iot_datarecive.service.impl.DeviceDataServiceImpl;
import com.waterspringer.mqtt.entity.EmqxClient;
import com.waterspringer.websocket.client.WebSocketServer;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmqxService
{
    private static final Logger logger = LoggerFactory.getLogger(EmqxService.class);

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private EmqxClient emqxClient;



    /**
     * 订阅的主题
     */
    private static final String prefix = "/+/+/";
    String test = prefix+"test";
    String sInfoTopic = prefix + "info/post";
    String sNtpTopic = prefix + "ntp/post";
    String sPropertyTopic = prefix + "property/post";
    String sFunctionTopic = prefix + "function/post";
    String sEventTopic = prefix + "event/post";
    String sShadowPropertyTopic = prefix + "property-offline/post";
    String sShadowFunctionTopic = prefix + "function-offline/post";

    /**
     * 发布的主题
     */
    String pStatusTopic = "/status/post";
    String pInfoTopic = "/info/get";
    String pNtpTopic = "/ntp/get";
    String pPropertyTopic = "/property/get";
    String pFunctionTopic = "/function/get";

    public void subscribe(MqttAsyncClient client) throws MqttException {
        client.subscribe(test, 1);
        // 订阅设备信息
        client.subscribe(sInfoTopic, 1);
        // 订阅时钟同步
        client.subscribe(sNtpTopic, 1);
        // 订阅设备属性
        client.subscribe(sPropertyTopic, 1);
        // 订阅设备功能
        client.subscribe(sFunctionTopic, 1);
        // 订阅设备事件
        client.subscribe(sEventTopic, 1);
        // 订阅属性（影子模式）
        client.subscribe(sShadowPropertyTopic, 1);
        // 订阅功能（影子模式）
        client.subscribe(sShadowFunctionTopic, 1);
        logger.info("mqtt订阅了设备信息和物模型主题");
    }

    /**
     * 消息回调方法
     * @param topic  主题
     * @param mqttMessage 消息体
     */
    @Async
    public void subscribeCallback(String topic, MqttMessage mqttMessage) throws InterruptedException {

        /**测试线程池使用*/
        logger.info("====>>>>线程名--{}",Thread.currentThread().getName());
        /**模拟耗时操作*/
        // Thread.sleep(1000);
        // subscribe后得到的消息会执行到这里面
        String message = new String(mqttMessage.getPayload());
        JSONObject jsonObject =  JSON.parseObject(message);
        DeviceData deviceData = new DeviceData();
//        BeanUtils.copyProperties(jsonObject, deviceData);
        deviceData.setMessage1((String)jsonObject.get("message1"));
        try
        {
            webSocketServer.sendInfo(JSON.toJSONString(deviceData),null);
        }
        catch (Exception e)
        {
           // throw new CarException(200,"websocke发送消息失败");
        }

        System.out.println("接收消息主题 : " + topic);
        System.out.println("接收消息Qos : " + mqttMessage.getQos());
        System.out.println("接收消息内容 : " + message);


        logger.info("接收消息主题 : " + topic);
        logger.info("接收消息Qos : " + mqttMessage.getQos());
        logger.info("接收消息内容 : " + message);


        String[] topicItem = topic.substring(1).split("/");
        Long productId = Long.valueOf(topicItem[0]);
        String deviceNum = topicItem[1];
        String name = topicItem[2];
        switch (name) {
            case "info":
                reportDevice(productId, deviceNum, message);
                break;
            case "ntp":
                publishNtp(productId, deviceNum, message);
                break;
            case "property":
                reportProperty(productId, deviceNum, message, false);
                break;
            case "function":
                reportFunction(productId, deviceNum, message, false);
                break;
            case "event":
                reportEvent(productId, deviceNum, message);
                break;
            case "property-offline":
                reportProperty(productId, deviceNum, message, true);
                break;
            case "function-offline":
                reportFunction(productId, deviceNum, message, true);
                break;
        }
    }

    /**
     * 上报设备信息
     */
    private void reportDevice(Long productId, String deviceNum, String message) {
//        try {
//            // 设备实体
//            Device deviceEntity=deviceService.selectDeviceBySerialNumber(deviceNum);
//            // 上报设备信息
//            Device device = JSON.parseObject(message, Device.class);
//            device.setProductId(productId);
//            device.setSerialNumber(deviceNum);
//            deviceService.reportDevice(device,deviceEntity);
//            // 发布设备状态
//            publishStatus(productId, deviceNum, 3, deviceEntity.getIsShadow(),device.getRssi());
//        } catch (Exception e) {
//            logger.error("接收设备信息，解析数据时异常 message={}", e.getMessage());
//        }
    }

    /**
     * 上报属性
     *
     * @param message
     */
    private void reportProperty(Long productId, String deviceNum, String message, boolean isShadow) {
//        try {
//            List<ThingsModelValueRemarkItem> thingsModelValueRemarkItems = JSON.parseArray(message, ThingsModelValueRemarkItem.class);
//            ThingsModelValuesInput input = new ThingsModelValuesInput();
//            input.setProductId(productId);
//            input.setDeviceNumber(deviceNum);
//            input.setThingsModelValueRemarkItem(thingsModelValueRemarkItems);
//            deviceService.reportDeviceThingsModelValue(input, 1, isShadow);
//        } catch (Exception e) {
//            logger.error("接收属性数据，解析数据时异常 message={}", e.getMessage());
//        }
    }

    /**
     * 上报功能
     *
     * @param message
     */
    private void reportFunction(Long productId, String deviceNum, String message, boolean isShadow) {
//        try {
//            List<ThingsModelValueRemarkItem> thingsModelValueRemarkItems = JSON.parseArray(message, ThingsModelValueRemarkItem.class);
//            ThingsModelValuesInput input = new ThingsModelValuesInput();
//            input.setProductId(productId);
//            input.setDeviceNumber(deviceNum);
//            input.setThingsModelValueRemarkItem(thingsModelValueRemarkItems);
//            deviceService.reportDeviceThingsModelValue(input, 2, isShadow);
//        } catch (Exception e) {
//            logger.error("接收功能，解析数据时异常 message={}", e.getMessage());
//        }
    }

    /**
     * 上报事件
     *
     * @param message
     */
    private void reportEvent(Long productId, String deviceNum, String message) {
//        try {
//            List<ThingsModelValueRemarkItem> thingsModelValueRemarkItems = JSON.parseArray(message, ThingsModelValueRemarkItem.class);
//            Device device = deviceService.selectDeviceBySerialNumber(deviceNum);
//            for (int i = 0; i < thingsModelValueRemarkItems.size(); i++) {
//                // 添加到设备日志
//                DeviceLog deviceLog = new DeviceLog();
//                deviceLog.setDeviceId(device.getDeviceId());
//                deviceLog.setDeviceName(device.getDeviceName());
//                deviceLog.setLogValue(thingsModelValueRemarkItems.get(i).getValue());
//                deviceLog.setRemark(thingsModelValueRemarkItems.get(i).getRemark());
//                deviceLog.setSerialNumber(device.getSerialNumber());
//                deviceLog.setIdentity(thingsModelValueRemarkItems.get(i).getId());
//                deviceLog.setLogType(3);
//                deviceLog.setIsMonitor(0);
//                deviceLog.setUserId(device.getUserId());
//                deviceLog.setUserName(device.getUserName());
//                deviceLog.setTenantId(device.getTenantId());
//                deviceLog.setTenantName(device.getTenantName());
//                deviceLog.setCreateTime(DateUtils.getNowDate());
//                // 1=影子模式，2=在线模式，3=其他
//                deviceLog.setMode(2);
//                logService.saveDeviceLog(deviceLog);
//            }
//        } catch (Exception e) {
//            logger.error("接收事件，解析数据时异常 message={}", e.getMessage());
//        }
    }


    /**
     * 1.发布设备状态
     */
    public void publishStatus(Long productId, String deviceNum, int deviceStatus, int isShadow,int rssi) {
        String message = "{\"status\":" + deviceStatus + ",\"isShadow\":" + isShadow + ",\"rssi\":" + rssi + "}";
        emqxClient.publish(1, false, "/" + productId + "/" + deviceNum + pStatusTopic, message);
    }

    /**
     * 2.发布设备信息
     */
    public void publishInfo(Long productId, String deviceNum) {
        emqxClient.publish(1, false, "/" + productId + "/" + deviceNum + pInfoTopic, "");
    }

    /**
     * 3.发布时钟同步信息
     *
     * @param message
     */
    private void publishNtp(Long productId, String deviceNum, String message) {
//        NtpModel ntpModel = JSON.parseObject(message, NtpModel.class);
//        ntpModel.setServerRecvTime(System.currentTimeMillis());
//        ntpModel.setServerSendTime(System.currentTimeMillis());
//        emqxClient.publish(1, false, "/" + productId + "/" + deviceNum + pNtpTopic, JSON.toJSONString(ntpModel));
    }

    /**
     * 4.发布属性
     */
//    public void publishProperty(Long productId, String deviceNum, List<IdentityAndName> thingsList) {
//        if (thingsList == null) {
//            emqxClient.publish(1, true, "/" + productId + "/" + deviceNum + pPropertyTopic, "");
//        } else {
//            emqxClient.publish(1, true, "/" + productId + "/" + deviceNum + pPropertyTopic, JSON.toJSONString(thingsList));
//        }
//    }

    /**
     * 5.发布功能
     */
//    public void publishFunction(Long productId, String deviceNum, List<IdentityAndName> thingsList) {
//        if (thingsList == null) {
//            emqxClient.publish(1, true, "/" + productId + "/" + deviceNum + pFunctionTopic, "");
//        } else {
//            emqxClient.publish(1, true, "/" + productId + "/" + deviceNum + pFunctionTopic, JSON.toJSONString(thingsList));
//        }
//
//    }

    /**
     * 设备数据同步
     *
     * @param deviceNumber 设备编号
     * @return 设备
     */
//    public Device deviceSynchronization(String deviceNumber) {
//        Device device=deviceService.selectDeviceBySerialNumber(deviceNumber);
//        // 1-未激活，2-禁用，3-在线，4-离线
//        if(device.getStatus()==3){
//            device.setStatus(4);
//            deviceService.updateDeviceStatus(device);
//            // 发布设备信息
//            publishInfo(device.getProductId(),device.getSerialNumber());
//        }
//        return device;
//    }
}
