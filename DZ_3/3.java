import org.json.JSONObject;

public class SqlQueryBuilder {
    public static void main(String[] args) {
        String query = "select * from students where ";
        JSONObject filters = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");

        StringBuilder whereClause = new StringBuilder();
        boolean isFirstFilter = true;

        for (String key : filters.keySet()) {
            String value = filters.getString(key);
            if (!value.equals("null")) {
                if (!isFirstFilter) {
                    whereClause.append(" and ");
                }
                whereClause.append(key).append(" = '").append(value).append("'");
                isFirstFilter = false;
            }
        }

        String finalQuery = query + whereClause.toString();
        System.out.println(finalQuery);
    }
}
