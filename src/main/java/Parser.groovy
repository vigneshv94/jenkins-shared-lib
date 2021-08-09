import org.yaml.snakeyaml.Yaml

class Parser implements Serializable {

        Parser load() {
            return new Parser();
        }

        static List<String> getProviderServices(Object script, String pathName, String serviceName) {
            Yaml parser = new Yaml()
            Map<Object, Object> parsedResult = (Map<Object, Object>) parser.load((script.readFile(pathName) as File).name)

            List<String> providesServices = (List<String>) parsedResult.get(serviceName);

            if(providesServices && providesServices.size > 0) {
                return providesServices;
            }
            return [];
        }
}
