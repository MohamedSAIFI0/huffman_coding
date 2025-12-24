# Huffman Coding Project

## Overview

This Java project implements Huffman coding, a lossless data compression algorithm. Huffman coding assigns variable-length codes to characters based on their frequency in the input text, with more frequent characters receiving shorter codes. This project demonstrates the complete process of building a Huffman tree, generating codes, encoding and decoding text, and visualizing the compression tree.

## Features

- **Frequency Analysis**: Counts character frequencies in input text
- **Huffman Tree Construction**: Builds an optimal binary tree using a priority queue
- **Code Generation**: Generates variable-length prefix codes for each character
- **Text Encoding**: Compresses text using the generated Huffman codes
- **Text Decoding**: Decompresses encoded binary strings back to original text
- **Compression Metrics**: Calculates compression ratio and efficiency
- **Tree Visualization**: Exports Huffman tree to GraphViz DOT format for visualization
- **File I/O**: Reads input from resources and can write output files

## Prerequisites

- Java 21 or higher
- Maven 3.6+ (for building the project)
- GraphViz (optional, for visualizing the Huffman tree)

## Project Structure

```
huffman_coding/
├── pom.xml                          # Maven project configuration
├── src/
│   └── main/
│       ├── java/com/example/
│       │   ├── Main.java            # Main application entry point
│       │   ├── HuffmanNode.java     # Huffman tree node class
│       │   ├── HuffmanTree.java     # Huffman tree construction and display
│       │   ├── HuffmanCodeGenerator.java # Code generation utilities
│       │   ├── Encoder.java         # Text encoding functionality
│       │   ├── Decoder.java         # Text decoding functionality
│       │   ├── FrequencyAnalyzer.java # Character frequency analysis
│       │   ├── FileUtils.java       # File reading/writing utilities
│       │   ├── CompressionUtils.java # Compression metrics calculation
│       │   └── HuffmanGraphvizExporter.java # GraphViz export functionality
│       └── resources/
│           └── exemple.txt          # Sample input text file
├── target/                          # Compiled classes (generated)
└── huffman_tree.dot                 # Generated GraphViz file for tree visualization
```

## Installation and Build

1. Clone or download the project to your local machine
2. Navigate to the project directory:
   ```bash
   cd huffman_coding
   ```
3. Build the project using Maven:
   ```bash
   mvn clean compile
   ```

## Usage

### Running the Application

Execute the main class to see the Huffman coding process in action:

```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

Or after compilation:

```bash
java -cp target/classes com.example.Main
```

### Sample Output

The application will:
1. Read the sample text from `src/main/resources/exemple.txt`
2. Display the original text
3. Show character frequencies
4. Print the Huffman tree structure
5. Display the generated Huffman codes
6. Show the encoded binary string
7. Decode and verify the result

### Example Text

The sample input file `exemple.txt` contains:
```
Bonjour tout le monde.La vie est belle.
```

### Custom Input

To use your own text file:
1. Place your text file in `src/main/resources/`
2. Modify the file path in `Main.java`:
   ```java
   String text = FileUtils.readFile("your_file.txt");
   ```

## Class Descriptions

### Core Classes

- **HuffmanNode**: Represents a node in the Huffman tree with character, frequency, and child references
- **HuffmanTree**: Constructs the Huffman tree from frequency data and provides tree traversal methods
- **HuffmanCodeGenerator**: Generates Huffman codes by traversing the tree and optimizes storage with ASCII arrays
- **Encoder**: Encodes text into binary strings using Huffman codes
- **Decoder**: Decodes binary strings back to original text using the Huffman tree

### Utility Classes

- **FrequencyAnalyzer**: Analyzes input text to count character frequencies
- **FileUtils**: Handles reading from resource files and writing output files
- **CompressionUtils**: Calculates compression ratios and efficiency metrics
- **HuffmanGraphvizExporter**: Exports the Huffman tree to GraphViz DOT format for visualization

### Main Class

- **Main**: Demonstrates the complete Huffman coding workflow with sample data

## Algorithm Explanation

1. **Frequency Analysis**: Count occurrences of each character in the input text
2. **Tree Construction**: 
   - Create leaf nodes for each character with their frequencies
   - Use a priority queue to repeatedly combine the two nodes with lowest frequencies
   - Continue until only one root node remains
3. **Code Generation**: Traverse the tree to assign binary codes (0 for left, 1 for right)
4. **Encoding**: Replace each character with its Huffman code
5. **Decoding**: Traverse the tree using the binary string to reconstruct the original text

## Visualization

The project generates a `huffman_tree.dot` file that can be visualized using GraphViz:

```bash
dot -Tpng huffman_tree.dot -o huffman_tree.png
```

This creates a visual representation of the Huffman tree showing character frequencies and code assignments.

## Compression Performance

Huffman coding provides optimal prefix codes. The compression ratio depends on the input text's character distribution:
- Texts with high frequency variation compress better
- Uniform distributions may not compress significantly
- The algorithm guarantees no code is a prefix of another, ensuring unambiguous decoding

## Dependencies

This project uses only standard Java libraries:
- `java.util.*` for collections and data structures
- `java.io.*` for file operations
- `java.nio.charset.*` for character encoding

## Contributing

To extend this project:
- Add support for binary file compression
- Implement adaptive Huffman coding
- Add more compression metrics
- Create a GUI for interactive visualization

## License

This project is for educational purposes. Feel free to use and modify the code for learning Huffman coding concepts.</content>
<filePath="c:\Users\Jetkey--pc\Downloads\S3\DS\End-project\huffman_coding\README.md