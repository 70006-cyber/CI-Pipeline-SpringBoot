# CI Pipeline Spring Boot — Fresh Setup

## Requirements
- JDK 17+
- Maven Daemon (mvnd) or Maven
- Docker Desktop for the PostgreSQL Testcontainers test (that test skips when Docker is unavailable)
- GitHub account for running the workflow remotely

## Run on Windows using Maven Daemon
Open this folder in VS Code. Confirm `pom.xml` is directly visible in the Explorer.

Run:
```powershell
& "$env:USERPROFILE\Downloads\maven-mvnd-1.0.6-windows-amd64\bin\mvnd.cmd" clean verify
```

Start the app:
```powershell
& "$env:USERPROFILE\Downloads\maven-mvnd-1.0.6-windows-amd64\bin\mvnd.cmd" spring-boot:run
```

Test these endpoints:
- http://localhost:8080/api/health
- http://localhost:8080/api/greet
- http://localhost:8080/api/greet?name=Lakshya

Stop the app with Ctrl+C.

## Pact note
`GreetingProviderPactTest` is excluded from the default Surefire build until a consumer-generated Pact JSON contract is supplied. To demonstrate actual provider contract verification, add a matching Pact JSON contract and then remove the exclusion from the `maven-surefire-plugin` configuration in `pom.xml`.

## GitHub Actions
The `.github/workflows/ci.yml` workflow runs `mvn --batch-mode --no-transfer-progress clean verify` on pushes and pull requests. For a GitHub runner, standard Maven is available via the setup-java action and the workflow does not need your local `mvnd` path.
