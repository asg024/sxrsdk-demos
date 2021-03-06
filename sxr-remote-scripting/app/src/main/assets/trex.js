importPackage(com.samsungxr);
importPackage(com.samsungxr.animation);

var scene = sxr.getMainScene();

var trex_url = new java.net.URL("https://github.com/sxrsdk/sxrsdk-demos/raw/master/sxr-meshanimation/app/src/main/assets/TRex_NoGround.fbx");
var trex = sxr.getAssetLoader().loadModel(trex_url);

var node = new SXRNode(sxr);
trex.getTransform().setPosition(0.0, -10.0, -10.0);
trex.getTransform().setRotationByAxis(90.0, 1.0, 0.0, 0.0);
trex.getTransform().setRotationByAxis(40.0, 0.0, 1.0, 0.0);
trex.getTransform().setScale(1.5, 1.5, 1.5);
trex.setName("trex");

node.addChildObject(trex);
scene.addNode(node);

var animator = trex.getComponent(SXRAnimator.getComponentType());
animator.setRepeatMode(1);
animator.setRepeatCount(-1);
node.getTransform().setPosition(0.0, -2.0, -10.0);
trex.getTransform().setRotationByAxis(90.0, 1.0, 0.0, 0.0);
animator.start();

