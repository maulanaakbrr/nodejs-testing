pipelineJob('nodejs-testing-pipeline') {
    description('Pipeline to test Node.js project from the repository.')

    triggers {
        scm('H/5 * * * *') // Check for changes every 5 minutes
    }

    definition {
        cps {
            script("""
                pipeline {
                    agent any

                    stages {
                        stage('Clone Repository') {
                            steps {
                                git branch: 'main', url: 'https://github.com/maulanaakbrr/nodejs-testing.git'
                            }
                        }

                        stage('Install Dependencies') {
                            steps {
                                sh 'npm install'
                            }
                        }

                        stage('Run Tests') {
                            steps {
                                sh 'npm test'
                            }
                        }
                    }

                    post {
                        success {
                            echo 'Tests ran successfully!'
                        }
                        failure {
                            echo 'Tests failed!'
                        }
                    }
                }
            """)
        }
    }
}
