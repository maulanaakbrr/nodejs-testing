pipelineJob('seed-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/maulanaakbrr/nodejs-testing.git'
                    }
                    branches('main')
                }
            }
            scriptPath('jenkins/pipeline.groovy') // Path to your DSL script in the repo
        }
    }
}
