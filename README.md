# 🌱 Greenhouse Monitoring and Control System 🌿

## 📌 Overview
This project is an **OSGi-based Greenhouse Monitoring and Control System** designed to manage and monitor environmental factors such as **humidity, soil moisture, and temperature**. The system is implemented using the OSGi framework and consists of individual plug-in projects for each sensor, a controller, and a consumer module.

---
## 🚀 Features
✅ **Real-time sensor monitoring** for humidity, soil moisture, and temperature  
✅ **Threshold-based automation** (e.g., turn on humidifiers or irrigation when levels drop)  
✅ **Dynamic user input to customize thresholds**  
✅ **OSGi modular design** for scalability and flexibility  

---
## 📂 Project Structure
```bash
GreenhouseMonitoringSystem/
├── 🌿 GreenhouseController/               # Main controller logic
├── 🎛️ GreenhouseControllerConsumer/       # Consumer bundle handling user interactions
├── 💧 HumidityService/                    # Humidity sensor implementation
├── 🌱 SoilMoistureService/                # Soil moisture sensor implementation
├── 🌡️ TemperatureSensorProducer/          # Temperature sensor implementation
└── 📜 README.md                           # Project documentation
```
---
## 🔧 Installation & Setup
### 🛠️ 1. Clone the Repository
```sh
git clone https://github.com/your-username/GreenhouseMonitoringSystem.git
cd GreenhouseMonitoringSystem
```

### 🏗️ 2. Import the Project into Eclipse IDE
- Open **Eclipse IDE**.
- Go to **File > Import > Existing Projects into Workspace**.
- Select the cloned repository folder.
- Click **Finish**.

### 🔄 3. Install & Configure OSGi Framework
- Ensure **Eclipse PDE (Plug-in Development Environment)** is installed.
- Use **Apache Felix** or **Equinox** OSGi runtime.

---
## ▶️ Running the System
### 🌐 Start the Producer Bundles
1. Right-click on `HumidityService`, `SoilMoistureService`, and `TemperatureSensorProducer`.
2. Select **Run As > OSGi Framework**.

### 🎛️ Start the Greenhouse Controller
1. Right-click on `GreenhouseController`.
2. Select **Run As > OSGi Framework**.

### 🖥️ Open OSGi Console
1. Go to **Window > Show View > Other > Console**.
2. Select **OSGi Console**.

### ▶️ Start Bundles (If Needed)
```sh
start <bundle_id>
```
Replace `<bundle_id>` with the actual ID from the OSGi console.

---
## 🛑 Stopping the System
To stop a bundle:
```sh
stop <bundle_id>
```
To exit the OSGi framework:
```sh
exit
```

---
## 🤝 Contributing
1. **Fork** the repository.
2. Create a **feature branch** (`git checkout -b feature-name`).
3. **Commit** your changes (`git commit -m "Added new feature"`).
4. **Push** to the branch (`git push origin feature-name`).
5. Open a **Pull Request**.

---

🌍💡 **Happy Coding & Keep Growing!** 🚀

