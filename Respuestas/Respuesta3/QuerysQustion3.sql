------------------------------------------------------------------------
--------------- Get all buses for Concessionaire 1----------------------
------------------------------------------------------------------------
SELECT * FROM bus
LEFT JOIN concessionaire ON bus.concessionaire_Id = concessionaire.id
WHERE concessionaire.name = 'Concessionaire 1';

------------------------------------------------------------------------
--Get all NVR devices for buses with type equal to “Bi-articulado”------
------------------------------------------------------------------------
SELECT * FROM device
LEFT JOIN bus ON bus.id = device.bus_Id
LEFT JOIN deviceType ON device.device_Type_Id = deviceType.id
WHERE bus.type = 'Bi-articulado'
AND deviceType.name = 'NVR';


------------------------------------------------------------------------
----Summarize the quantity of devices by status (Active / Inactive)-----
-------------------------and bus motor----------------------------------
---------------(Diesel / Gas / Electric / Hybrid).----------------------
SELECT bus.motor,device.status Device_Status,COUNT(bus.motor) CANTIDAD FROM device
LEFT JOIN bus ON bus.id = device.bus_Id
LEFT JOIN deviceType ON device.device_Type_Id = deviceType.id
GROUP BY device.status,bus.motor
ORDER BY bus.motor;