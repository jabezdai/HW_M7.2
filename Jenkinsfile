pipeline {
    agent any
    /* insert Declarative Pipeline here */
    stages {
        stage('run-test') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew test'
                jacoco(
                    classPattern: 'app/build/classes',
                    inclusionPattern: '**/*.class',
                    exclusionPattern: '**/*Test*.class',
                    execPattern: 'app/build/jacoco/**/*.exec'
                )
            }

        }
        stage('sonarqube-analysis'){
            environment{
                SONAR_TOKEN = credentials('{SQ_token}')
            }
            steps{
                sh'''./gradlew sonarqube \
                      -Dsonar.projectKey=M7.3 \
                      -Dsonar.host.url=http://140.134.26.54:10990 \
                      -Dsonar.login=c242655f9d2ce6eb7ce1b37665d013a64fc97d2b
                '''
            }
        }
    }
}
