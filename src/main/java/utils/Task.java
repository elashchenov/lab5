package utils;

import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;

public class Task {
    @Getter
    private String title;
    @Getter
    private List<String> parameterTitles;
    private Consumer<List<String>> execCodeConsumer;

    public Task(String title, List<String> parameterTitles, Consumer<List<String>> execCodeConsumer) {
        this.title = title;
        this.parameterTitles = parameterTitles;
        this.execCodeConsumer = execCodeConsumer;
    }

    public void run(List<String> programArguments) {
        if ((parameterTitles != null) && (programArguments != null)
                && programArguments.size() != parameterTitles.size()) {
            throw new IllegalArgumentException("The initial number of parameters does not match the final one");
        }
        execCodeConsumer.accept(programArguments);
    }

    @Override
    public String toString() {
        return title;
    }
}
