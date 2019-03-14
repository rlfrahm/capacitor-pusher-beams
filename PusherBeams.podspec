
  Pod::Spec.new do |s|
    s.name = 'PusherBeams'
    s.version = '0.0.1'
    s.summary = 'Pusher Beams Capacitor plugin'
    s.license = 'MIT'
    s.homepage = 'git@github.com:cesarbarone/capacitor-pusher-beams.git'
    s.author = 'César Barone'
    s.source = { :git => 'git@github.com:cesarbarone/capacitor-pusher-beams.git', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end