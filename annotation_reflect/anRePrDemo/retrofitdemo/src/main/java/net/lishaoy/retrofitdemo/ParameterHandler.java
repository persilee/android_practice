package net.lishaoy.retrofitdemo;

public abstract class ParameterHandler {

    abstract void apply(ServiceMethod serviceMethod, String value);

    static class QueryParameterHandler extends ParameterHandler {

        String key;

        public QueryParameterHandler(String key) {
            this.key = key;
        }

        @Override
        void apply(ServiceMethod serviceMethod, String value) {
            serviceMethod.addQueryParameter(key,value);
        }
    }

    static class FileParameterHandler extends ParameterHandler {

        String key;

        public FileParameterHandler(String key) {
            this.key = key;
        }

        @Override
        void apply(ServiceMethod serviceMethod, String value) {
            serviceMethod.addFiledParameter(key,value);
        }
    }

}
