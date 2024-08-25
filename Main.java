import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var block = new BlockImpl("red", "brick");
        var block1 = new BlockImpl("green", "brick");
        var block2 = new BlockImpl("yellow", "brick");
        var block3 = new BlockImpl("blue", "brick");
        var block4 = new BlockImpl("orange", "brick");

        var blocks = new ArrayList<Block>();
        blocks.add(block);
        blocks.add(block1);
        blocks.add(block2);
        blocks.add(block3);
        blocks.add(block4);

        var subBlocks = new ArrayList<Block>();
        subBlocks.add(block);
        subBlocks.add(block1);
        var compositeBlock = new CompositeBlockImpl("black", "composite", subBlocks);
        blocks.add(compositeBlock);

        var wall = new Wall(blocks);
        var count = wall.count();
        System.out.println(count);

        var colorBlock = wall.findBlockByColor("blue");
        System.out.println(colorBlock);
        var colorBlock2 = wall.findBlockByColor("black");
        System.out.println(colorBlock2);

        var findBlocks = wall.findBlocksByMaterial("brick");
        System.out.println(findBlocks);
        if (blocks.size() == findBlocks.size()){
            System.out.println("All works!");
        }
    }
}
