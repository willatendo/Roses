package roses.content.client.resourcepacks;

public class ResourcePack {
}// extends net.minecraft.server.packs.AbstractPackResources {
//	private static ModFile modFile = ModList.get().getModFileById(ModUtils.ID).getFile();
//	private static String subFolder = "";
//	private String name = "";
//
//	public ResourcePack(String subFolder, String id) {
//		super(modFile.getFilePath().toFile());
//
//		ResourcePack.subFolder = subFolder;
//		this.name = id;
//	}
//
//	@Override
//	public String getName() {
//		return this.name;
//	}
//
//	private static String getSubFolders() {
//		return subFolder;
//	}
//
//	@Override
//	public void close() {
//	}
//
//	@Override
//	protected InputStream getResource(String name) throws IOException {
//		final Path path = modFile.getLocator().findPath(modFile, getSubFolders() + name);
//		if (!Files.exists(path)) {
//			throw new ResourcePackFileNotFoundException(path.toFile(), getSubFolders() + name);
//		}
//
//		return Files.newInputStream(path, StandardOpenOption.READ);
//	}
//
//	@Override
//	protected boolean hasResource(String name) {
//		return Files.exists(modFile.getLocator().findPath(modFile, getSubFolders() + name));
//	}
//
//	@Override
//	public Collection<ResourceLocation> getResources(PackType type, String resourceNamespace, String pathIn, int maxDepth, Predicate<String> filter) {
//		try {
//			Path root = modFile.getLocator().findPath(modFile, getSubFolders() + type.getDirectory()).toAbsolutePath();
//			Path inputPath = root.getFileSystem().getPath(pathIn);
//			return Files.walk(root).map(path -> root.relativize(path.toAbsolutePath())).filter(path -> path.getNameCount() > 1 && path.getNameCount() - 1 <= maxDepth).filter(path -> !path.toString().endsWith(".mcmeta")).filter(path -> path.subpath(1, path.getNameCount()).startsWith(inputPath)).filter(path -> filter.test(path.getFileName().toString())).map(path -> new ResourceLocation(path.getName(0).toString(), Joiner.on('/').join(path.subpath(1, Math.min(maxDepth, path.getNameCount()))))).collect(Collectors.toList());
//		} catch (IOException e) {
//			return Collections.emptyList();
//		}
//	}
//
//	@Override
//	public Set<String> getNamespaces(PackType type) {
//		try {
//			Path root = modFile.getLocator().findPath(modFile, getSubFolders() + type.getDirectory()).toAbsolutePath();
//			return Files.walk(root, 1).map(path -> root.relativize(path.toAbsolutePath())).filter(path -> path.getNameCount() > 0).map(p -> p.toString().replaceAll("/$", "")).filter(s -> !s.isEmpty()).collect(Collectors.toSet());
//		} catch (IOException e) {
//			return Collections.emptySet();
//		}
//	}
//}
