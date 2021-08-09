

def call(String appCode) {
    pipeline {
        agent any

        stages {
            stage('Hello') {
                steps {
                    echo 'Hello World'
                    echo "--------->${appCode}<---------"
                    script {
                        Parser parser;
                        parser = parser.load();
                        def vars = parser.getProviderServices(this, "service.yml", "ms-il-jdbc")
                        echo "${vars}"
                    }
                }
            }
        }
    }
}
