declare global {
  interface PluginRegistry {
    PusherBeams?: PusherBeamsPlugin;
  }
}

export interface PusherBeamsPlugin {
  echo(options: { value: string }): Promise<{value: string}>;
  setUserID(options: { beamsAuthURL: string, userID: string }): Promise<{ beamsAuthURL: string, userID: string }>;
}
