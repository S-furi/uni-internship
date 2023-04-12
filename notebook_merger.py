import sys
import nbformat

if __name__ == "__main__":
    if (len(sys.argv) < 3):
        print("usage: python notebook_merger.py <notebook_path_1> <notebook_path_2>")
        exit(1)


first_notebook = nbformat.read(sys.argv[1], 4)
second_notebook = nbformat.read(sys.argv[2], 4)

final_notebook = nbformat.v4.new_notebook(metadata=first_notebook.metadata)

final_notebook.cells = first_notebook.cells + second_notebook.cells

nbformat.write(final_notebook, './merged_notebook.ipynb')

