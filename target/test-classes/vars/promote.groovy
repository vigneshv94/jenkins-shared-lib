import main.java.Parser

def call(String appCode) {
    pipeline {
        agent any
        Parser parser;

        stages {
            stage('Hello') {
                steps {
                    echo 'Hello World'
                    echo "--------->${appCode}<---------"
                    script {
                        parser = parser.load();
                        def vars = parser.getProviderServices(this, "service.yml", "ms-il-jdbc")
                        echo "${vars}"
                    }
                }
            }
        }
    }
}
