# JMeter GUI Practice Guideline (SauceDemo)

This guide helps you practice performance testing using JMeter GUI with `www.saucedemo.com`.

## 1. Local Setup (Installation)

Since the Maven plugin runs in "headless" mode (no UI), you need to install the JMeter App separately to create test plans.

### For macOS (Homebrew)
```bash
brew install jmeter
open /opt/homebrew/bin/jmeter  # Or just type 'jmeter' in terminal
```

### For Windows / Linux
1. Download **Apache JMeter Binaries (.zip)** from jmeter.apache.org.
2. Extract the zip file.
3. Go to `bin` folder and run `jmeter.bat` (Windows) or `jmeter.sh` (Linux).

---

## 2. Creating Your First Test Plan

Follow these steps to build a test scenario simulating users visiting SauceDemo.

### Step A: Create Users (Thread Group)
1. Open JMeter.
2. Right-click on **Test Plan** > **Add** > **Threads (Users)** > **Thread Group**.
3. Configure:
   - **Name**: `SauceDemo Visitors`
   - **Number of Threads (users)**: `5` (Simulate 5 users)
   - **Ramp-up period (seconds)**: `5` (Start 5 users over 5 seconds = 1 user per sec)
   - **Loop Count**: `1`

### Step B: Set Global Config (HTTP Request Defaults)
To avoid typing `https://www.saucedemo.com` in every request.
1. Right-click on **SauceDemo Visitors** > **Add** > **Config Element** > **HTTP Request Defaults**.
2. Configure:
   - **Protocol**: `https`
   - **Server Name or IP**: `www.saucedemo.com`

### Step C: Add Requests (Samplers)

**Scenario 1: Visit Home Page**
1. Right-click on **SauceDemo Visitors** > **Add** > **Sampler** > **HTTP Request**.
2. Configure:
   - **Name**: `Home Page`
   - **Method**: `GET`
   - **Path**: `/` (Leave empty or use /)

**Scenario 2: Visit Inventory Page**
1. Right-click on **SauceDemo Visitors** > **Add** > **Sampler** > **HTTP Request**.
2. Configure:
   - **Name**: `Inventory Page`
   - **Method**: `GET`
   - **Path**: `/inventory.html`

### Step D: Add "Think Time" (Timers)
Real users don't click immediately. They read and wait.
1. Right-click on **SauceDemo Visitors** > **Add** > **Timer** > **Constant Timer**.
2. Configure:
   - **Thread Delay (in milliseconds)**: `2000` (Wait 2 seconds between requests).

### Step E: Validate Results (Listeners)
1. Right-click on **SauceDemo Visitors** > **Add** > **Listener** > **View Results Tree**.
   - *Best for debugging errors.*
2. Right-click on **SauceDemo Visitors** > **Add** > **Listener** > **Summary Report**.
   - *Best for seeing statistics (Min/Max/Average time).*

### Step F: Add Checks (Assertions)
1. Right-click on **Home Page** request > **Add** > **Assertions** > **Response Assertion**.
2. Configure:
   - **Field to Test**: `Text Response`
   - **Patterns to Test**: Click `Add` and type `Swag Labs`.
   - *This ensures the page actually loaded the correct content.*

---

## 3. Running the Test (Dry Run)

1. Click the **Green Play Button** in the toolbar.
2. Click on **View Results Tree** to see the traffic.
   - ✅ Green Shield = Pass
   - ❌ Red Shield = Fail (Check Response Data tab to see why)

---

## 4. Integrating with Maven Project

Once your test plan works in the GUI:

1. **Save the file**:
   - File > Save Test Plan as...
   - Navigate to your project: `.../testng-practice/src/test/jmeter/`
   - Name it: `saucedemo_load_test.jmx`

2. **Run via Terminal**:
   Now you can run it without the GUI using the Maven command configured in the project.

   ```bash
   mvn verify -Pjmeter
   ```

3. **Check Reports**:
   Maven will generate reports in `target/jmeter/reports`.

## 5. Key JMeter Concepts for Beginners

| Component | Analogy | Purpose |
|-----------|---------|---------|
| **Thread Group** | The Users | Defines how many people are testing. |
| **Sampler** | The Action | What the user does (Click link, Submit form). |
| **Listener** | The Report | Shows the results of the test. |
| **Assertion** | The Judge | Decides if the result is Pass or Fail. |
| **Timer** | The Pause | Simulates reading time/thinking time. |
| **Config Element** | The Settings | Shared settings like URL, Cookies. |