# Mobile testing w/ Appium + Java

Mobile automated testing using Appium and Java

## 🧠You will learn to

* Create an automated iOS test
* Run test in Sauce Labs
* Set test name
* Report results to Sauce Labs
* Upload an app to Sauce Storage
* Create an automated Android test
* Run tests in parallel

## Your Instructor: Nikolay Advolodkin

<img src="https://ultimateqa.com/wp-content/uploads/2020/09/Sauce-Con-Green-Hoody.jpg" alt="me" width="200"/>

- 🔭 I’m the founder of [Ultimate QA](https://ultimateqa.com/)
- 🏢 I’m a Sr Solutions Architect at Sauce Labs
- 🌱 I’m currently working on [Sauce Bindings](https://github.com/saucelabs/sauce_bindings)
- 💬 Ask me about environmentalism, veganism, test automation, and fitness
- 😄 Pronouns: he/him
- ⚡ Fun fact: I'm a Ukranian, Russian, Jew that was born in Uzbekistan and raised in US 🤯
- 📫 Follow me for testing and dev training
  - [Java Testing Tips Weekly](https://ultimateqa.ck.page/selenium-java-tips)
  - [Testing Training on Youtube](https://www.youtube.com/ultimateqa?sub_confirmation=1)
  - [LinkedIn](https://www.linkedin.com/in/nikolayadvolodkin/)
  - [Twitter to know about all my events](https://twitter.com/intent/follow?screen_name=nikolay_a00)

---

### Gitpod setup

ℹ Gitpod lets you run an entire Dev environment from a browser! You can use this approach if you don't know how to setup a local Java environment.

1. Sign up for a free [GitHub account](https://github.com/)
2. [Fork this repository](https://docs.github.com/en/get-started/quickstart/fork-a-repo)
 * Make sure you are logged into GitHub
 * Click the Fork in the upper right of the GitHub.
 * Give the repo a ⭐ while you're here 🤩
3. In the browser address bar, prepend the GitHub url (`https://github.com/USERNAME/automation-best-practices-java`) with `https://gitpod.io/#`
    * The resulting url should look as follows:
   
      > https://gitpod.io/#https://github.com/USERNAME/mobile-appium-java
   
4. Once the Gitpod.io URL is loaded, you will need to sign in with the GitHub account you created earlier 
5. Once the development environment is loaded, you should see 'Ready to test!' in the Terminal window in the lower portion of the window, run the following commands in that Terminal to set your `SAUCE_USERNAME`, `SAUCE_ACCESS_KEY`:

ℹ️ You can get your Sauce Labs Username and Access Key by going to the [Sauce Labs user settings page](https://app.saucelabs.com/user-settings)

```bash
eval $(gp env -e SAUCE_USERNAME=<sauce_username>)
eval $(gp env -e SAUCE_ACCESS_KEY=<sauce_access_key>)
```

> Replace <sauce_username>, <sauce_access_key> with your credentials

Once you have run those 3 commands, you can run the following commands to test your environment variables:

```bash
echo $SAUCE_USERNAME
echo $SAUCE_ACCESS_KEY
```

Run sanity tests

```bash
mvn test -Dtest="IOSTest" -X
```

<br/>
  <details>
    <summary>
      <strong>Click here</strong> to see an example console output.
    </summary>

    [INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  35.863 s


  </details>

<br/>

***✅👏Environment setup is complete if tests passed***

---

### Local environment setup

1. Sign up for a free [GitHub account](https://github.com/)
2. [Fork this repository](https://docs.github.com/en/get-started/quickstart/fork-a-repo)
 * Make sure you are logged into GitHub
 * Click the Fork in the upper right of the GitHub.
 * Give the repo a ⭐ while you're here 🤩
3. Clone **your fork** of the repository to your machine. Must have [Git installed](https://git-scm.com/downloads)

```bash
git clone URL_OF_YOUR_FORK
```

Setup environment variables on your system
* [Mac/Linux](https://docs.saucelabs.com/basics/environment-variables/#setting-up-environment-variables-on-macos-and-linux-systems)
* [Windows](https://docs.saucelabs.com/basics/environment-variables/#setting-up-environment-variables-on-windows-systems)

Navigate to the directory of where you cloned your repo

`cd YOUR_FORK_DIR/automation-best-practices/workshop`

Run sanity tests

```java
mvn test -Dtest="SanityTest#functionalWorks" -X
```

<br/>
  <details>
    <summary>
      <strong>Click here</strong> to see an example console output.
    </summary>

        
        Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 54.305 sec

        Results :

        Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------
        [INFO] Total time:  56.063 s
        [INFO] Finished at: 2021-11-03T16:03:20-04:00
        [INFO] ------------------------------------------------------------------------
        
  </details>

</br>

### ✅👏Environment setup is complete if tests passed

