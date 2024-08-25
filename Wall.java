import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.getColor().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        var blocksResult = new ArrayList<Block>();

        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                blocksResult.add(block);
            }
        }
        return blocksResult;
    }

    @Override
    public int count() {
        var count = 0;
        for (var block : blocks) {
            count += countBlocks(block);
        }
        return count;
    }

    private int countBlocks(Block block) {
        var count = 0;
        if (block instanceof CompositeBlock composite) {
            for (var subBlock : composite.getBlocks()) {
                count += countBlocks(subBlock);
            }
        }
        else {
            count += 1;
        }
        return count;
    }
}
