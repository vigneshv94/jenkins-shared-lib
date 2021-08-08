import spock.lang.Specification

class ParserTest extends Specification {
    Parser parser

    void setup() {

    }

    def "load Master Service List"() {
        def script = new Object()
        script.metaClass.readFile {
            new File(it).text
        }

        expect:
        Parser.getProviderServices(script, "src/test/resources/services.yml", "ms-il-jdbc")
    }
}
