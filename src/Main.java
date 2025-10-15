import java.lang.String;

void main(String[] args) {
    String filePath;

    do {
        IO.println("Give the file path (press q to quit):");
        filePath = IO.readln();

        if(!filePath.equals("q")) {
            IO.println();
            var analyzerResult = FileAnalyzer.generateFullReport(filePath);
            if(analyzerResult != null)
                IO.println(Utils.getResultContent(analyzerResult, false));

            IO.println("\nExport results to csv? (Y or N)?");
            boolean shouldExport = IO.readln().equalsIgnoreCase("Y");
            if(shouldExport) {
                try {
                    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                    Path path = Path.of("export_" + LocalDateTime.now().format(dateTimeFormat) + ".csv");
                    Files.writeString(path, Utils.getResultContent(
                            analyzerResult, true),
                            StandardOpenOption.CREATE,
                            StandardOpenOption.TRUNCATE_EXISTING);
                }
                catch(IOException ex) {
                    IO.println("An I/O exception occurred: " + ex);
                }
            }
            IO.println("\n--------------------------------------");
        }
    }
    while(!filePath.equals("q"));
}