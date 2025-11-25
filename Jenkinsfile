pipeline {
	agent any
    tools {
		jdk 'Java17 '
    }

    stages {
		stage('Checkout') {
			steps {
				git branch: 'master',
                url: 'https://github.com/proximacentauri11/BoniGarciaProject.git'
            }
        }

        stage('Build') {
			steps {
				bat 'mvn clean compile -DskipTests'
            }
        }

        stage('Tests') {
			steps {
				bat 'mvn test -Dallure.results.directory=allure-results'
            }
            post {
				always {
					allure includeProperties: false,
                           results: [[path: 'allure-results']]
                    // Для Zephyr добавьте здесь вызов API
                }
            }
        }
    }

    post {
		always {
			publishHTML target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'allure-report',
                reportFiles: 'index.html',
                reportName: 'Allure Report'
            ]
        }
    }
}