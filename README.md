# API Test Automation for JSONPlaceholder

This project is an automated API testing framework for the REST API. It demonstrates API test automation using Java, Maven, TestNG, and REST-assured with best practices.

[![GitHub Release](https://img.shields.io/github/v/release/RaiwashiRai/api-test-automation)](https://github.com/RaiwashiRai/api-test-automation/releases)
![Last Commit](https://img.shields.io/github/last-commit/RaiwashiRai/api-test-automation)
![Top Language](https://img.shields.io/github/languages/top/RaiwashiRai/api-test-automation)

## 🕸️ APIs Used
- JSONPlaceholder API


## 📚 Project Structure

```
src/
  test/
    java/
      ryu/
        api/jsonplaceholder/      # API client abstraction
        tests/jsonplaceholder/    # Test classes (CRUD, Negative, Schema, Smoke, Temp)
        utils/                    # Config and test data utilities
    resources/
      ryu/schemas/               # JSON schemas for validation
.github/
  workflows/                     # CI/CD pipeline (GitHub Actions)
```



## 🚀 Tech Stack

- **Java**
- **TestNG**
- **REST-assured**
- **Surefire-reports**


## ⚙️ Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/api-test-automation.git
   cd api-test-automation
   ```

2. **Install dependencies:**
   ```sh
   mvn clean install
   ```

## 🧪 Running Tests

- **All tests:**
  ```sh
  mvn test
  ```

- **Specific groups (e.g., smoke):**
  ```sh
  mvn test -Dgroups=smoke
  ```

- **View test reports:**  
  Open `target/surefire-reports/index.html` in your browser for a summary.



## 🏗️ CI/CD

- Manually triggered execution via [GitHub Actions](.github/workflows/ci.yml).
- Test summary generated for each run.




## 📄 License

Copyright (c) 2025 Shubham Gaikwad (GitHub: RaiwashiRai). All Rights Reserved. See [LICENSE](LICENSE) for details.
