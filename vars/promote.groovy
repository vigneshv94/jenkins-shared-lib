import main.java.Parser

def call(String appCode) {
    Parser parser
    pipeline {
        agent any

        stages {
            stage('Hello') {
                steps {
                    echo 'Hello World'
                    echo "--------->${appCode}<---------"
                    Parser.getProviderServices(this, "service.yml", "ms-il-jdbc")
                }
            }
        }
    }
}
