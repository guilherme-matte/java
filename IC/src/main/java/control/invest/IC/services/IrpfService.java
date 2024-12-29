package control.invest.IC.services;

import control.invest.IC.models.IrpfModel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class IrpfService {

    public Map<String, Double> formatedJsonIrpf(IrpfModel irpfModel) {
        Map<String, Double> campos = new HashMap<>();
        try {
            Field[] fields = IrpfModel.class.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType().equals(double.class)) {
                    double value = (double) field.get(irpfModel);
                    if (value > 0) {
                        campos.put(field.getName(), value);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro no acesso aos campos");
        }
        return campos;
    }
}
